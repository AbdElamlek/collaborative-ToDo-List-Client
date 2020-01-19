/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import Entities.UserEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahmedpro
 */
public class UserEntityData implements Subject {
    
    private UserEntity userEntity;
    private List<Observer> list;
    
    public UserEntityData() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = list.indexOf(observer);
        if (i >= 0)
            list.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < list.size(); i++)
            list.get(i).updateGUI(userEntity);
    }
    
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        notifyAllObservers();
    }
    
}
