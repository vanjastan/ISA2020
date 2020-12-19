export class Meds {
    constructor(
        public id: string,
        public name: string,
        public code: string,
        public type: string,
        public contradictions: string,
        public ingredients: string,
        public dailydose: string,
        public replacement: string,
        public shape: string,
        public manufacturer: string,
        public issuing: string,
        public notes: string,
    ){}
}