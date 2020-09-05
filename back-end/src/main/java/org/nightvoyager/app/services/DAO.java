package org.nightvoyager.app.services;

import org.greenrobot.eventbus.Subscribe;
import org.nightvoyager.app.services.data.PersonInfo;
import org.nightvoyager.app.services.data.PersonRepo;
import org.nightvoyager.core.data.IDataAccessor;
import org.nightvoyager.core.data.roler.IPersonInfo;
import org.nightvoyager.core.event.SaveStateEvent;
import org.nightvoyager.core.state.TickEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DAO implements IDataAccessor {

    @Autowired
    private PersonRepo personRepo;

    @Subscribe
    public void onSaveState(SaveStateEvent e){
        personRepo.flush();
    }

    private List<PersonInfo> covert(IPersonInfo[] persons){
        return Arrays.stream(persons)
                .map(it->PersonInfo.valueOf(it))
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends IPersonInfo> getPersons() {
        return personRepo.findAll();
    }

    @Override
    public void addOrUpdate(IPersonInfo... persons) {
        personRepo.saveAll(covert(persons));
    }

    @Override
    public void remove(IPersonInfo... persons) {
        personRepo.deleteAll(covert(persons));
    }
}
