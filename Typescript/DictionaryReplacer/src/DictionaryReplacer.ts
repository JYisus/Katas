class DictionaryReplacer {
    replace(stringBeforeReplace: string, dictionary: Object) {
        if (stringBeforeReplace === "" || Object.keys(dictionary).length === 0) return "";

        let finalStringSparsed: string[] = [];
        for (let word of stringBeforeReplace.split(" ")) {
            const wordWithoutDollars: string = word.slice(1,word.length-1);
            const isWordInDictionary: boolean = dictionary.hasOwnProperty(wordWithoutDollars);

            if (word.match('\$.*\$') && isWordInDictionary) {
                const wordSubstituted: string = dictionary[wordWithoutDollars];
                finalStringSparsed.push(wordSubstituted);
            } else {
                finalStringSparsed.push(word);
            }
        }

        return finalStringSparsed.join(" ");
    }
}

export {
    DictionaryReplacer
};