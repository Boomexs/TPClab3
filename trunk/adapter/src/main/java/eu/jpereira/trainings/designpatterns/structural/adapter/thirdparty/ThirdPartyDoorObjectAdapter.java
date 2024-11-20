package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {

    private ThirdPartyDoor thirdPartyDoor;

    public ThirdPartyDoorObjectAdapter() {
        this.thirdPartyDoor = new ThirdPartyDoor();
    }


    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            this.thirdPartyDoor.unlock(code);
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.OPEN);
        } catch (Exception e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public void close() {
        try {
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.CLOSED);
            this.thirdPartyDoor.lock();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isOpen() {
        return this.thirdPartyDoor.getState() == ThirdPartyDoor.DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        if(!newCode.equals(newCodeConfirmation)) {
            throw new CodeMismatchException();
        }
        try {
            this.thirdPartyDoor.unlock(oldCode);
            this.thirdPartyDoor.setNewLockCode(newCode);
        }
        catch (Exception e) {
            throw new IncorrectDoorCodeException();
        }
    }

    @Override
    public boolean testCode(String code) {
        try {
            this.thirdPartyDoor.unlock(code);
            this.thirdPartyDoor.lock();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
