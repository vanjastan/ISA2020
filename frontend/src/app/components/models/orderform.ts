export class OrderForm{
    constructor(
        public id:number,
        public medicament_name: string,
        public quantity: number,
        public end_date: string,
        public status: string,
        
    ){}
}