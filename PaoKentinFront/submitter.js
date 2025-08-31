const submitter = document.querySelector("[submitter]");
submitter.addEventListener("submit", function (event) {
    event.preventDefault();

    const atributos = event.target.getAttribute("submitter").split(" ");
    const formData = new FormData(event.target);
    const dadoQueVaiSerEnviado = {};

    for ([key, value] of formData) {
        dadoQueVaiSerEnviado[key] = value;
    }

    fetch(atributos[0], {
        headers: { 'content-type': 'application/json' },
        method: atributos[1],
        body: JSON.stringify(dadoQueVaiSerEnviado)
    })
    .then(response => response.text())
    .then(text => {
        alert(text);
        location.reload();
    })
    .catch(error => {
        alert("Erro ao enviar dados. Tente novamente.");
        console.error(error);
    });
});
