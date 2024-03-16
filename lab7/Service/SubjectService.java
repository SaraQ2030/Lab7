package org.example.lab7.Service;

import org.example.lab7.Model.Student;
import org.example.lab7.Model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectService {
    ArrayList<Subject> subjects=new ArrayList<>();

    public ArrayList<Subject> getSubjects(){
        return subjects;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public boolean updateSubject(int id,Subject subject){
        for (Subject s:subjects){
            if (s.getSub_id()==id){
                subjects.set(subjects.indexOf(s),subject);
                return true;
            }
        }
        return false;
    }

    public boolean deleteSubject(int id){
        for (Subject s:subjects){
            if (s.getSub_id()==id){
                subjects.remove(subjects.indexOf(s));
                return true;
            }
        }
        return false;
    }

    public ArrayList<Subject> fullSubjects(){
        ArrayList<Subject>list=new ArrayList<>();
        for (Subject s:subjects){
            if (s.isFull()){
                subjects.add(s);
            }
        }
        return list;
    }





    ArrayList<Student> users=new ArrayList<>();

    public ArrayList<Student> getUser(){
        return users;
    }

    public void addUser(Student user){
        users.add(user);
    }

    public boolean updateUser(int id,Student user){
        for (Student u:users){
            if (u.getId()==id){
                users.set(users.indexOf(u),user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id){
        for (Student u:users){
            if (u.getId()==id){
                users.remove(users.indexOf(u));
                return true;
            }
        }
        return false;
    }

    public boolean addSubjectToStudent(int std_id,int sub_id,Student student){
        for (Student std:users){
            if (std.getId().equals(std_id)){
                for (Subject sbj:subjects){
                    if (sbj.getSub_id().equals(sub_id)   &&  !sbj.isFull()){
users.set(users.indexOf(std), student);
return true;
                    }
            }
        }

        }
        return false;
    }
}
