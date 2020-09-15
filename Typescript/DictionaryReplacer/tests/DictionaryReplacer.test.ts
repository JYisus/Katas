import { DictionaryReplacer } from "../src/DictionaryReplacer";


describe("DictionaryReplacer", () => {
    const dictionaryReplacer = new DictionaryReplacer();
    
    it("can't replace anything if the dictionary or the string is empty, so it returns empty string", () => {
        const stringBeforeReplace = ""
        const dictionary = {};
        expect(dictionaryReplacer.replace(stringBeforeReplace, dictionary)).toBe("");
        expect(dictionaryReplacer.replace("just empty dictionary", dictionary)).toBe("");
        expect(dictionaryReplacer.replace("", { "empty" : "string"})).toBe("");
    });

    it("replace the word between $ with his corresponding substitution in the dictionary", () => {
        const stringBeforeReplace = "$user$"
        const dictionary = {"user": "John Doe"};

        expect(dictionaryReplacer.replace(stringBeforeReplace, dictionary)).toBe("John Doe");
    });

    it("if the word to replace isn't in the dictionary, doesn't replace this word", () => {
        const stringBeforeReplace = "$username$";
        const dictionary = {"user": "John Doe"};

        expect(dictionaryReplacer.replace(stringBeforeReplace, dictionary)).toBe(stringBeforeReplace);
    });

    it("replace the word between $ in a large phrase with his corresponding substitution in the dictionary", () => {
        const stringBeforeReplace1 = "$user$ is actually logged";
        const stringBeforeReplace2 = "$user$ is actually logged, his email is $email$";
        const dictionary = {"user": "John Doe"};

        const stringAfterReplace1 = "John Doe is actually logged";
        const stringAfterReplace2 = "John Doe is actually logged, his email is $email$";


        expect(dictionaryReplacer.replace(stringBeforeReplace1, dictionary)).toBe(stringAfterReplace1);
        expect(dictionaryReplacer.replace(stringBeforeReplace2, dictionary)).toBe(stringAfterReplace2);

    });

    it("replaces all the words that actually are in the dictionary", () => {
        const stringBeforeReplace = "$user$ is actually logged, his email is $email$";
        const dictionary = {"user":"John Doe", "email":"john@doe.com"}

        const stringAfterReplace = "John Doe is actually logged, his email is john@doe.com";

        expect(dictionaryReplacer.replace(stringBeforeReplace, dictionary)).toBe(stringAfterReplace);
    });

    it("replace the word, even if it isn't between whitespaces", () => {
        const stringBeforeReplace = "Sr.$user$,";
        const dictionary = {"user":"John Doe", "email":"john@doe.com"}

        const stringAfterReplace = "Sr.John Doe,";

        expect(dictionaryReplacer.replace(stringBeforeReplace, dictionary)).toBe(stringAfterReplace);
    });
});