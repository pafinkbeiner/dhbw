import { Machine, OperationMode } from "./Machine";

export interface MachineTemplate{

    // Data
    machineData: Machine;

    // Funktionen
    powerOn: Function;
    resetToDefault: Function;
    checkConstraints: () => boolean;
    setMachineMode: (data: OperationMode) => any;
}