import { LogHandler } from "../Helper/Log";
import { Machine, OperationMode, Position } from "../models/Machine";

export class MachineInstance implements Machine {

    machineDetails: { model: string; serialNumber: number; sparDistance: number; };
    operation: { power: boolean; statusLED: { green: boolean; yellow: boolean; red: boolean; }; running: boolean; operationMode: OperationMode; };
    injectionUnit: { position: Position; };
    savetyDoor: { position: Position; locked: boolean; };
    lockingUnit: { locked: boolean; position: Position; };

    constructor() {
        this.machineDetails =  {model: "string", serialNumber: 123456, sparDistance: 500 };
        this.operation = { power: false, statusLED: { green: false, yellow: false, red: false, }, running: false, operationMode: OperationMode.semiAutomatic };
        this.injectionUnit = { position: { max: 500, min: 0, x: 500}};
        this.savetyDoor =  { position: { max: 500, min: 0, x: 500}, locked: false };
        this.lockingUnit = { locked: false, position: { max: 500, min: 0, x: 500}, };
    }

    powerOn(){
        this.operation.power = true;
        this.operation.statusLED.red = true;
    };

    resetToDefault(){

    };

    closeSafetyDoor(){

    };

    openSafetyDoor(){

    };

    setMachineMode(data: OperationMode){
        if(data == OperationMode.automatic || data == OperationMode.semiAutomatic){
            this.operation.operationMode = data;
        }else{
            LogHandler.getLogInstance().log("error while setting machine mode");
        }
    }

}