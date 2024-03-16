package org.example.lab7.Service;

import jdk.dynalink.linker.LinkerServices;
import org.example.lab7.Model.Instructor;
import org.example.lab7.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InstructorService {
    ArrayList<Instructor> users = new ArrayList<>();

    public ArrayList<Instructor> getUser() {
        return users;
    }

    public void addUser(Instructor user) {
        users.add(user);
    }

    public boolean updateUser(int id, Instructor user) {
        for (Instructor u : users) {
            if (u.getId() == id) {
                users.set(users.indexOf(u), user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (Instructor u : users) {
            if (u.getId() == id) {
                users.remove(users.indexOf(u));
                return true;
            }
        }
        return false;
    }

    public ArrayList<Instructor> searchNumClass(int clas) {
        ArrayList<Instructor> list = new ArrayList<>();
        for (Instructor i : users) {
            if (i.getNum_class() <= clas) {
                list.add(i);
            }
        }
        return list;
    }
//اضافة سوبرفايزر كلاس للانستركتر
    public boolean addClass(int id_super, int id_inst) {
        for (Instructor i : users) {
            if (i.getId().equals(id_super)  &&  i.getStatus().equalsIgnoreCase("supervisor")) {
                    for (Instructor s : users) {
                        if (s.getId().equals(id_inst)  &&  !(s.isRetired())   &&    s.getNum_class() < 5) {
                                    s.setNum_class(s.getNum_class() + 1);
                                    return true;
                                }
                            }
                        }
                    }
        return false;
                }

    //بحث على عدد سنوات الخبرة
    public ArrayList<Instructor> searchExperYear(int exper){
        ArrayList<Instructor> list=new ArrayList<>();
        for (Instructor i:users){
            if (i.getExper_year()>= exper){
                list.add(i);
            }
        }
        return list;
    }

    //سوبيرفايزر يغير حالة الانستركتر اذا كانت سنةات الخبرة 10 سنوات فاكثر
    public boolean chngeStatus(int id_sup,int id_ins){
        for (Instructor i:users){
            if (i.getId().equals(id_sup)  &&   i.getStatus().equalsIgnoreCase("supervisor")){
                 for (Instructor s:users){
                        if (s.getId().equals(id_ins)  &&  !s.isRetired()  && s.getExper_year()>=10){
                            s.setStatus("supeervisor");
                            return true;
                        }
                    }
                }
            }
        return false;
        }

        public ArrayList<Instructor> searchSalary(int sal){
        ArrayList<Instructor> list=new ArrayList<>();
        for (Instructor i:users){
            if (i.getSalary()>=sal){
                list.add(i);
            }
        }return list;
        }

        public boolean changeRetire(int id){
        for (Instructor i:users){
            if (i.getId().equals(id)){
                if (i.getWorkYear()==20 && ! i.isRetired()){
                    i.setRetired(true);
                    return true;
                }
            }
        }return false;
        }

        public ArrayList<Instructor> retirList(){
        ArrayList<Instructor>list=new ArrayList<>();
        for (Instructor i:users){
            if (i.isRetired()){
                list.add(i);
            }
        }
        return list;
        }

    }




