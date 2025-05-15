package com.example.employeehierarchysystem.service;

import com.example.employeehierarchysystem.model.BinaryTree;
import com.example.employeehierarchysystem.model.Employee;
import com.example.employeehierarchysystem.model.TreeNode;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

//import javax.annotation.PostConstruct;
//import javax.enterprise.context.ApplicationScope;
//import javax.inject.named;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeHierarchyService {
    private BinaryTree<Employee> employeeTree;

    /*//Getter for employeeTree (optional, if needed externally)
    public BinaryTree<Employee> getEmployeeTree() {
        return employeeTree;
    }*/

    @PostConstruct
    public void init() {
        employeeTree = new BinaryTree<>();

        // Initialize with some sample data
        employeeTree.insert(new Employee(1, "John Doe", "CEO"));
        employeeTree.insert(new Employee(2, "Jane Smith", "CTO"));
        employeeTree.insert(new Employee(3, "Mike Johnson", "CFO"));
        employeeTree.insert(new Employee(4, "Alice Williams", "VP Engineering"));
        employeeTree.insert(new Employee(5, "Bob Brown", "VP Marketing"));
    }

    public String getHierarchyAsString() {
        StringBuilder sb = new StringBuilder();
        buildHierarchyString(employeeTree.getRoot(), 0, sb);
        return sb.toString();
    }

    private void buildHierarchyString(TreeNode<Employee> node, int level, StringBuilder sb) {
        if (node == null) return;

        sb.append("  ".repeat(level));
        sb.append("└─ ").append(node.getData()).append("\n");

        buildHierarchyString(node.getLeft(), level + 1, sb);
        buildHierarchyString(node.getRight(), level + 1, sb);
    }

    public List<Employee> getEmployeesInOrder() {
        List<Employee> employees = new ArrayList<>();
        inOrderTraversal(employeeTree.getRoot(), employees);
        return employees;
    }

    private void inOrderTraversal(TreeNode<Employee> node, List<Employee> employees) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), employees);
            employees.add(node.getData());
            inOrderTraversal(node.getRight(), employees);
        }
    }

    public void addEmployee(Employee employee) {
        employeeTree.insert(employee);
    }
}