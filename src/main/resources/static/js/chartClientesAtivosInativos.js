var cativos = [[${ ativos }]];
var cinativos = [[${ inativos }]];
var caguardando_contato = [[${ aguardando_contato }]];
var cem_simulacao = [[${ em_simulacao }]];
var cnegado = [[${ negado }]];
var cem_aprovacao = [[${ em_aprovacao }]];
var csimulacao_pronta = [[${ simulacao_pronta }]];
var cinativos = [[${ inativos }]];
var cinativos = [[${ inativos }]];

var ctx1 = document.getElementById("chart-ativos-inativos");


/* CONFIGS CHART ATIVOS E INATIVOS */
const labelsAtivosInativos = [
    'Ativos',
    'Inativos',

];
const dataAtivosInativos = {
    labels: labelsAtivosInativos,
    datasets: [{
        label: 'Ativos e Inativos',
        backgroundColor: ['rgb(255, 99, 132)', 'rgb(239, 00, 132)'],

        data: [cativos, cinativos],
    }]
};
const configAtivosInativos = {
    type: 'pie',
    data: dataAtivosInativos,
    options: {
        maintainAspectRatio: true,

    }
};

var chartGraph = new Chart(ctx1, configAtivosInativos) 