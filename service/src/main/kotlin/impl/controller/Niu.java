package impl.controller;

import entity.User;

import java.util.List;

/**
 * @author futao
 * Created on 2017/12/26 - 21:52.
 */
public class Niu {
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Niu(List<User> list) {
        this.list = list;
    }

    public Niu() {
    }
}
