package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    public ThirdPartyDoorAdapter() {};

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            unlock(code);
            setState(DoorState.OPEN);
        }
        catch (Exception e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public void close() {
        try{
            setState(DoorState.CLOSED);
            lock();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isOpen() {
        return getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if(!newCode.equals(newCodeConfirmation)){
            throw new CodeMismatchException();
        }
        try {
            unlock(oldCode);
            setNewLockCode(newCode);
        }
        catch(Exception e){
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public boolean testCode(String code) {
        try{
            unlock(code);
            lock();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
