import { DiamondGenerator } from "../src/DiamondGenerator";

const diamondGenerator = new DiamondGenerator("A");

describe('generateLine', () => {
    test('given a letter A and a limit letter A, generates and A', () => {
        let diamond_a_line = diamondGenerator.generateLine("A", "A");
        expect(diamond_a_line).toBe("A");
    });
    test('given a letter A and a limit letter B, generates an string with 1 space at the beggining and just one A', () => {
        let diamond_a_line = diamondGenerator.generateLine("A", "B");
        expect(diamond_a_line).toBe(" A");
    });
    test('given a letter A and a limit letter C, generates an string with 2 space at the beggining and just one A', () => {
        let diamond_a_line = diamondGenerator.generateLine("A", "C");
        expect(diamond_a_line).toBe("  A");
    });
    test('given a letter B and a limit letter B, generates an string with one B at the beggining, one space, and one B at the end', () => {
        let diamond_a_line = diamondGenerator.generateLine("B", "B");
        expect(diamond_a_line).toBe("B B");
    });
    test('given a letter C and a limit letter C, generates an string with one C at the beggining, three spaces, and one C at the end', () => {
        let diamond_a_line = diamondGenerator.generateLine("C", "C");
        expect(diamond_a_line).toBe("C   C");
    });
    test('given a letter B and a limit letter C, generates an string with one space at the beginning, one B, one space, and one b at the end', () => {
        let diamond_a_line = diamondGenerator.generateLine("B", "C");
        expect(diamond_a_line).toBe(" B B");
    });
    
});

describe('generate', () => {

    test('given and empty string, returns an empty string', () => {
        let a_diamond = diamondGenerator.generate("");
        expect(a_diamond).toBe("");
    });

    test('given an A, prints just an A', () => {
        let a_diamond = diamondGenerator.generate("A");
        expect(a_diamond).toBe("A");
    });

    test(`given a B returns a diamond like 
     A
    B B
     A`, () => {
        let b_diamond = diamondGenerator.generate("B");
        expect(b_diamond).toBe(" A\nB B\n A");
    });

    test(`given a C returns the a diamond like
      A
     B B
    C   C
     B B
      A`, () => {
        let c_diamond = diamondGenerator.generate("C");
        expect(c_diamond).toBe("  A\n B B\nC   C\n B B\n  A");
    })

    test(`given a D returns the a diamond like
       A
      B B
     C   C
    D     D
     C   C
      B B
       A`, () => {
        let d_diamond = diamondGenerator.generate("D");
        expect(d_diamond).toBe("   A\n  B B\n C   C\nD     D\n C   C\n  B B\n   A");
    })
});
