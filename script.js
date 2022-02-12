var editor = monaco.editor.create(document.getElementById('code-container'), {
    value: ['function x() {', '\tconsole.log("Hello world!");', '}'].join('\n'),
    language: 'javascript',
    scrollBeyondLastLine: false,
});
