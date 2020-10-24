import { Machine, OperationMode } from "./Machine";

export interface MachineTemplate{

    // Data
    machineData: Machine;

    // Funktionen
    powerOn: Function;
    resetToDefault: Function;
    persistData: Function;
    checkConstraints: () => boolean;
    setMachineMode: (data: OperationMode) => any;

    //Automated Workflow
    closeLockingUnit: (next: Function) => any;
    mountInjectionUnit: (next: Function) => any;
    injectMaterial: (next: Function) => any;
    unmountInjectionUnit: (next: Function) => any;
    wait: (next: Function) => any;
    openLockingUnit: (next: Function) => any;
}