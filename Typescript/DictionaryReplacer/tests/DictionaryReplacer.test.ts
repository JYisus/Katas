import { DictionaryReplacer } from "../src/DictionaryReplacer";


describe("DictionaryReplacer", () => {
    const dictionaryReplacer = new DictionaryReplacer();
    
    it("can't replace anything if the dictionary or the string is empty, so it returns empty string", () => {
        const dstringBeforeReplace = ""
        const dictionary = {};
        expect(dictionaryReplacer.replace(dstringBeforeReplace, dictionary)).toBe("");
        expect(dictionaryReplacer.replace("just empty dictionary", dictionary)).toBe("");
        expect(dictionaryReplacer.replace("", { "empty" : "string"})).toBe("");
    });

    it("replace the word between $ with his corresponding substitution in the dictionary", () => {
        const dstringBeforeReplace = "$user$"
        const dictionary = {"user": "John Doe"};

        expect(dictionaryReplacer.replace(dstringBeforeReplace, dictionary)).toBe("John Doe");
    });

    it("if the word to replace isn't in the dictionary, doesn't replace this word", () => {
        const dstringBeforeReplace = "$username$";
        const dictionary = {"user": "John Doe"};

        expect(dictionaryReplacer.replace(dstringBeforeReplace, dictionary)).toBe(dstringBeforeReplace);
    });

    it("replace the word between $ in a large phrase with his corresponding substitution in the dictionary", () => {
        const dstringBeforeReplace = "$user$ is actually logged"
        const dictionary = {"user": "John Doe"};

        const stringAfterReplace = "John Doe is actually logged"

        expect(dictionaryReplacer.replace(dstringBeforeReplace, dictionary)).toBe(stringAfterReplace);
    });
});