import { Medicine } from "./medicine";
import { Pharmacies } from "./pharmacies";

export class MedicineReservation{
    public id: number;
    public dateReservation: string;
    public numberReservation: number;
    public selectedPharmacy: Pharmacies;
    public medicine: Medicine;
}