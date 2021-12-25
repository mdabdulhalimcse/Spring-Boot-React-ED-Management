package com.abdulhalim.service.Implementation;

import com.abdulhalim.entity.Department;
import com.abdulhalim.repository.DepartmentRepository;
import com.abdulhalim.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository deptRepo;

    @Override
    public Department saveDepartment(Department dept) {
        return deptRepo.save(dept);
    }

    @Override
    public Department updateDepartment(Department dept) {
        return deptRepo.save(dept);
    }

    @Override
    public Object deleteDepartmentById(Long id) {
        HashMap<String,String> deleteMsg = new HashMap<>();
        try {
            deptRepo.delete(deptRepo.findById(id).get());
        }catch (NoSuchElementException e){
            deleteMsg.put("id: "+id,"Not Found");
            return deleteMsg;
        }catch (Exception e){
            deleteMsg.put("id: "+id,"Sorry! can not delete parent row.");
            return deleteMsg;
        }
        deleteMsg.put("id: "+id,"Department has been successfully deleted.");
        return deleteMsg;
    }

    @Override
    public Department getDepartmentById(Long id) {
        Department dept = deptRepo.findById(id).get();
        return dept;
    }

    @Override
    public List<Department> getAllDepartment() {
        List<Department> deptList = deptRepo.findAll();
        return deptList;
    }
}
