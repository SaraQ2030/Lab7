package org.example.lab7.Service;

import org.example.lab7.Model.Instructor;
import org.example.lab7.Model.Student;
import org.example.lab7.Model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
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
    //search graduated student
    public ArrayList<Student>searchGrad(){
        ArrayList<Student> list=new ArrayList<>();
        for (Student s:users){
            if (s.isGraduated()){
                list.add(s);
            }
        }
        return list;
    }
//search training student
    public ArrayList<Student>searchTraining(){
        ArrayList<Student> list=new ArrayList<>();
        for (Student s:users){
            if (s.isTraining()){
                list.add(s);
            }
        }
        return list;
    }
    //change status to graduated
    public boolean changeGrad(int id){
        for (Student s:users){
            if (s.getId().equals(id) &&  s.getHours()>=60 && s.isTraining()){
                s.setGraduated(true);
                return true;
            }
        }
        return false;
    }
//change status to training
    public boolean changeTraining(int id){
        for (Student s:users){
            if (s.getId().equals(id) &&  s.getHours()>=30){
                s.setTraining(true);
                return true;
            }
        }
        return false;
    }


    //calculate attendance

    public ArrayList<Student> calAttendance(int day){
        ArrayList<Student> list=new ArrayList<>();
        for (Student s:users){
            if (s.getAttendance()>=day){
                list.add(s);
            }
        }
        return list;
    }


    //add subject to student
//    public boolean addSubject(int sup_id,int std_id,int sub_id ,Instructor sup,Student student,Subject subject){
//        for(Instructor sup:users){
//            if (sup.getId().equals(sup_id) && sup.getStatus().equalsIgnoreCase("supervisor")){
//                for (Student st:users){
//                    if (st.getId().equals(std_id)){
//                        //check subject
//                        {
//                            //add subject to student
//                        }
//                        }
//                    }
//
//                }
//            }
//        }
    }

