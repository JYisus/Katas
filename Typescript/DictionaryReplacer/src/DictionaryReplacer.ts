class DictionaryReplacer {
    replace(stringBeforeReplace: string, dictionary: Object) {
        if (stringBeforeReplace === "" || Object.keys(dictionary).length === 0) return "";

        let finalStringSparsed: string[] = [];
        for (let word of stringBeforeReplace.split(" ")) {
            if (word.match('\$.*\$') && dictionary.hasOwnProperty(word.slice(1,word.length-1))) {
                    finalStringSparsed.push(dictionary[word.slice(1,word.length-1)]);
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