var list = document.querySelector("#list");
var form = document.getElementById("cadastro-usuario");
var input = document.querySelector("#cadastro");
var candidato = loadEmpresa();

let regexCnpj= ('/^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/');

let regexNomeEmpresa = ('/(á-úa-zA-ZÁ-Ú?\s)/');

let regexEmailEmpresa = new RegExp('/^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/');

let regexCep = new RegExp('/^[0-9]{5}-[0-9]{3}$/');

let regexTagsEmpresa= ('/@"\<([\/?\s?\w]+)\>/');


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
    candidato.push(newEmpresa);
    addListItem(newEmpresa);
    input.value = "";
   
});





function salvarCadastro() {
   
    
    var empresa = document.getElementById('cadastro-empresa').value   
   
    localStorage.setItem('key' , empresa);
  
    var a = [empresa];
   
    localStorage.getItem("key" , a);


    
    //armazenar user dentro de uma lista array
    
    //pegar os valores da lista e atualizar o localStorage (setItem)

    //criar função array list aqui com foreach

   
 
}




function addListItem(empresa) {
    var item = document.createElement("li");
    var label = document.createElement("label");
    var checkbox = document.createElement("input");
    checkbox.addEventListener("change", function () {
        empresa.completed = checkbox.checked;
        saveEmpresa();
    });

  
    checkbox.type = "checkbox";
    checkbox.checked = empresa.completed;
    label.append(checkbox, empresa.title);
    item.append(label);
    list === null || list === void 0 ? void 0 : list.append(item);
    return true;
}
function saveEmpresa() {
    localStorage.setItem("CANDIDATO", JSON.stringify(empresa));
}
function loadEmpresa() {
    var empresaJSON = localStorage.getItem("EMPRESA");
    if (empresaJSON == null)
        return [];
    return JSON.parse(empresaJSON);
}
