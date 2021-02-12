export class LoyaltyProgram{
    constructor(
        public id: number,
        public medicine_points: number,
        public examination_points: number,
        public consultation_points: number,
        public category: string
        ){}
}