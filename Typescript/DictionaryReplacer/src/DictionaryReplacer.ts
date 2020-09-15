class DictionaryReplacer {
    replace(stringBeforeReplace: string, dictionary: Object): string {
        if (stringBeforeReplace === "" || Object.keys(dictionary).length === 0) return "";

        for(let word of Object.keys(dictionary)) {
            stringBeforeReplace = stringBeforeReplace.replace(`\$${word}\$`,dictionary[word]);
        }
        return stringBeforeReplace;
    }
}

export {
    DictionaryReplacer
};