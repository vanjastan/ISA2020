export class Prescription{
    constructor(
        public date_of_pub: string,
        public status: string,
        public medicine: string,
        public patientId: number
        ){}
}