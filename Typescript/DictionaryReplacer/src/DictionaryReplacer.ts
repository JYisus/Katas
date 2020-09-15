class DictionaryReplacer {
    replace(stringBeforeReplace: string, dictionary: Object): string {
        if (stringBeforeReplace === "" || Object.keys(dictionary).length === 0) return "";

        let finalStringSparsed: string[] = [];

        finalStringSparsed = stringBeforeReplace.split(" ").map((word) => this.replaceWordsBetweenDollars(word,dictionary))
        

        return finalStringSparsed.join(" ");
    }

    private replaceWordsBetweenDollars(word: string, dictionary: Object): string {
        const wordWithoutDollars: string = word.slice(1,word.length-1);
        const isWordInDictionary: boolean = dictionary.hasOwnProperty(wordWithoutDollars);

        if (word.match('\$.*\$') && isWordInDictionary) {
            const wordSubstituted: string = dictionary[wordWithoutDollars];
            return wordSubstituted;
        }

        return word;
    }
}

export {
    DictionaryReplacer
};