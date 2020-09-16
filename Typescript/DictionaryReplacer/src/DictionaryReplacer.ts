class DictionaryReplacer {
    replace(string: string, dictionary: object): string {
        if (string === "" || Object.keys(dictionary).length === 0) return "";

        for(let word of Object.keys(dictionary)) {
            string = string.replace(`\$${word}\$`,dictionary[word]);
        }
        return string;
    }
}

export {
    DictionaryReplacer
};
