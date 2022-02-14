const [onEditorTypeChanged, runCode] = (function () {
    var exportObjects = [];

    var editor = null;
    var languageExamples = {
        'javascript': "function hi() {\n\tconsole.log('Hello, world!');\n}\n",
        'python': "def main():\n\tprint('Hello, world!')\n",
        'scala': '@main def hello = println("Hello, world!")\n'
    }


    function selectedModel() {
        var select = document.getElementById('models-select');
        return select.options[select.selectedIndex].value;
    }
    var currentLanguage = selectedModel();


    function createLanguageModel(modelLanguage) {
        return monaco.editor.createModel(languageExamples[modelLanguage], modelLanguage);
    }


    var avaliableModels = (function () {
        var select = document.getElementById('models-select');
        var modelsNames = [];
        for (var i = 0; i < select.childNodes.length; ++i) {
            modelsNames.push(select.childNodes[i].value);
        }
        modelsNames = modelsNames.filter(x => x);

        var avaliableModels = {}
        for (var i = 0; i < modelsNames.length; ++i) {
            var model = modelsNames[i];
            avaliableModels[model] = createLanguageModel(model);
        }
        return avaliableModels;
    })();


    function onEditorTypeChanged(selectedObject) {
        var type = selectedObject.value;
        currentLanguage = type;
        editor.setModel(avaliableModels[type]);
    }
    exportObjects.push(onEditorTypeChanged);


    function runCode() {
        var code = editor.getValue();
        var language = currentLanguage;
        console.log({
            'language': language,
            'code': code,
        });
    }
    exportObjects.push(runCode);


    editor = monaco.editor.create(document.getElementById('code-container'), {
        value: languageExamples[selectedModel()],
        language: selectedModel(),

        scrollBeyondLastLine: false,
        roundedSelection: false,
        lineNumbers: 'on',
        readOnly: false,
        wordWrap: 'on',
        theme: 'vs'
    });

    return exportObjects;
})();
