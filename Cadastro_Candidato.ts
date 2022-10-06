
var list = document.querySelector("#list");
var form = document.getElementById("cadastro-usuario");
var input = document.querySelector("#cadastro");
var candidato = loadCandidato();
candidato.forEach(addListItem);
form === null || form === void 0 ? void 0 : form.addEventListener("submit", function (e) {
    e.preventDefault();
    if ((input === null || input === void 0 ? void 0 : input.value) == "" || (input === null || input === void 0 ? void 0 : input.value) == null)
        return;
    var newCandidato = {
        id: (0, uuid_1.v4)(),
        title: input.value,
        completed: true,
        createdAt: new Date()
    };
    candidato.push(newCandidato);
    addListItem(newCandidato);
    input.value = "";
   
});





function salvarCadastro() {
   
    
    var user = document.getElementById('cadastro').value   
   
    localStorage.setItem('key' , user);
  
    var a = [user];
   
    localStorage.getItem("key" , a);


    
    //armazenar user dentro de uma lista array
    
    //pegar os valores da lista e atualizar o localStorage (setItem)

    //criar função array list aqui com foreach

   
 
}




function addListItem(candidato) {
    var item = document.createElement("li");
    var label = document.createElement("label");
    var checkbox = document.createElement("input");
    checkbox.addEventListener("change", function () {
        candidato.completed = checkbox.checked;
        saveCandidato();
    });

  
    checkbox.type = "checkbox";
    checkbox.checked = candidato.completed;
    label.append(checkbox, candidato.title);
    item.append(label);
    list === null || list === void 0 ? void 0 : list.append(item);
    return true;
}
function saveCandidato() {
    localStorage.setItem("CANDIDATO", JSON.stringify(candidato));
}
function loadCandidato() {
    var candidatoJSON = localStorage.getItem("CANDIDATO");
    if (candidatoJSON == null)
        return [];
    return JSON.parse(candidatoJSON);
}
