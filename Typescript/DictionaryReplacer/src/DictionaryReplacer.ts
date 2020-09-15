class DictionaryReplacer {
    replace(stringBeforeReplace: string, dictionary: Object): string {
        if (stringBeforeReplace === "" || Object.keys(dictionary).length === 0) return "";

        const stringSplited: string[] = stringBeforeReplace.split(" ");

        let finalStringSparsed: string[] = stringSplited.map((word) => this.replaceWordsBetweenDollars(word,dictionary))

        return finalStringSparsed.join(" ");
    }

    private replaceWordsBetweenDollars(word: string, dictionary: Object): string {

        if (word.match('.*\$.*\$.*')) {
            const firstDollar: number = word.indexOf("$");
            const secondDollar: number = word.indexOf("$",firstDollar+1);
            const stringBeforDollar: string = word.slice(0,firstDollar);
            const stringAfterDollar: string = word.slice(secondDollar+1, word.length)
            const wordWithoutDollars: string = word.slice(firstDollar+1,secondDollar);
            const isWordInDictionary: boolean = dictionary.hasOwnProperty(wordWithoutDollars);
            const wordSubstituted: string = dictionary[wordWithoutDollars];
            
             if (isWordInDictionary) return stringBeforDollar+wordSubstituted+stringAfterDollar;
        }

        return word;
    }
}

export {
    DictionaryReplacer
};