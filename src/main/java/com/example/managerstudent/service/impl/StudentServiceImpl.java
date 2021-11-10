package com.example.managerstudent.service.impl;

import com.example.managerstudent.dto.ListStudentWithPagi;
import com.example.managerstudent.dto.Pagination;
import com.example.managerstudent.dto.StudentDTO;
import com.example.managerstudent.dto.SubjectDTO;
import com.example.managerstudent.entities.*;
import com.example.managerstudent.mapper.IStudentMapper;
import com.example.managerstudent.repository.*;
import com.example.managerstudent.service.IStudentService;
import com.example.managerstudent.service.ISubjectService;
import com.example.managerstudent.utils.IDateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    IStudentRepository studentReponsitory;
    @Autowired
    ISubjectRepository subjectRepository;
    @Autowired
    II18nRepository i18nRepository;
    @Autowired
    II18nTranslateRepository i18nTranslateRepository;
    @Autowired
    IMapDataRepository mapDataRepository;

    @Autowired
    ISubjectService subjectService;

    @Autowired
    IStudentMapper<StudentDTO, StudentEntity> studentMapper;


    @Autowired
    @Qualifier("dateTimeFormatter")
    DateTimeFormatter dtf;

    @Autowired
    IDateValidator dateValidator;


    @Override
    public ListStudentWithPagi getListStudents(Integer page, Integer size, String search, String column, String order) {

        ListStudentWithPagi  lswp = new ListStudentWithPagi();
        Pagination pagi = new Pagination();
        //check param
        Sort sort = null;
        if (column==""){
            sort = Sort.by("id");
        }else {
            sort = Sort.by(column);
        }
        switch (order){
            case "asc":
                sort = sort.ascending();
                break;
            case "desc":
                sort = sort.descending();
                break;
            default:
                sort = sort.ascending();
                break;
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<StudentEntity> studentEntities = null;
        if (search.equals("")) studentEntities = studentReponsitory.findAll(pageable);
        if (!search.equals("")) studentEntities = studentReponsitory.findAllByName(search,pageable);
        List<StudentEntity> students = studentEntities.getContent();
        List<StudentDTO> listStudentDTO = students.stream().map(e -> {
            StudentDTO dto = studentMapper.convertToDTO(e);
            String opNameVi = mapDataRepository.getValueByName(e.getName().concat(".vi"));
            String opNameEn = mapDataRepository.getValueByName(e.getName().concat(".en"));
            dto.setNameVN(opNameVi);
            dto.setNameEN(opNameEn);
            return dto;
        }).collect(Collectors.toList());
        lswp.setData(listStudentDTO);
        pagi.setTotalPage(studentEntities.getTotalPages());
        pagi.setSize(studentEntities.getSize());
        pagi.setPage(studentEntities.getPageable().getPageNumber());
        pagi.setSearch(search);
        pagi.setColumn(column);
        pagi.setOrder(order);
        lswp.setPagination(pagi);
        return lswp;
    }

    @Override
    public StudentDTO getStudentDTO(Long id) {
        StudentDTO dto = null;
        Optional<StudentEntity> se = studentReponsitory.findById((long) id);
        if (!se.isPresent()) return null;
        String nameI18n = se.get().getName();
        dto = studentMapper.convertToDTO(se.get());
        String opNameVi = mapDataRepository.getValueByName(nameI18n.concat(".vi"));
        String opNameEn = mapDataRepository.getValueByName(nameI18n.concat(".en"));
        dto.setNameVN(opNameVi);
        dto.setNameEN(opNameEn);

        List<SubjectDTO> listSubDTO = null;
        listSubDTO = subjectService.findAllByIdStudent(id);
        dto.setListSubject(listSubDTO);
        return dto;
    }


    @Override
    @Transactional
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        dateValidator.idValid(studentDTO.getBirthday());
            StudentEntity se = null;
            se = studentMapper.convertToEntity(studentDTO);
            se = studentReponsitory.save(se);
            StringBuilder sb = new StringBuilder()
                    .append("Student.")
                    .append(se.getId().toString())
                    .append(".name");
            se.setName(sb.toString());
            se = studentReponsitory.save(se);
            if (studentDTO.getNameVN() != null) {
                MapDataEntity mde = new MapDataEntity();
                mde.setName(sb.append(".vi").toString());
                mde.setValue(studentDTO.getNameVN());
                mapDataRepository.save(mde);
            }
            if (studentDTO.getNameVN() != null) {
                MapDataEntity mde = new MapDataEntity();
                mde.setName(sb.delete(sb.length() - 3, sb.length()).append(".en").toString());
                mde.setValue(studentDTO.getNameEN());
                mapDataRepository.save(mde);
            }
            studentDTO.setId(se.getId());
            return studentDTO;
    }

    @Override
    public void deleteById(Long id) {
        studentReponsitory.deleteById(id);
    }
}
