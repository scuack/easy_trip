class Entity {
    
    url ="http//localhost:8080/api/";

    constructor(endpoint) {
        this.endpoint = endpoint;
    }
    /* Se crean métodos basados en los que se crearon en la conexión del back  */
    /* estos van a manejar objetos para realziar promesas (objetos que representa la terminación o el fracaso de una operación asincrónica)*/
    insert(object) { 
        /* Dentro de la promesa se necesitan tres parámetros nomralmente, el primero es una response, 
        el segundo es un request y el tercero es una función anónoma
        que es la que permite que se reciba una respuesta a travpes de una petición*/
        return new Promise((fullfil, reject) =>fetch(this.url + this.endpoint, {
            body: JSON.stringify(object),
            headers: { "Content-Type": "application/json"},
            method: "POST",
            mode:"cors",
    }).then(response  => response.json().then(response.ok ? fullfill : reject, reject), reject));
    }

    /* aquí en el header se indica que la petición que se realice será un json
    También que el metodo que se va a usar es un GET, osea que se pedirá un dato
    por último se usa el modo cors que significa (intercambio de recursos de origen cruzado)*/
    findAll(){
        return new Promise((fullfil, reject) =>fetch(this.url + this.endpoint, {
            headers: { "Content-Type": "application/json" },
            method: "GET",
            mode: "cors",
        }).then(response => response.json().then(response-ok ? fullfil : reject, reject), reject));
    }

    findById(id){
        return new Promise((fullfill, reject) =>fetch(this.url + this.endpoint + id, {
            headers: { "Content-Type": "application/json" },
            method: "GET",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill : reject, reject), reject));
    }

    update(object){
        return new Promise((fullfil, reject) =>fetch(this.url + this.endpoint, {
            body: JSON.stringify(object),
            headers: { "Content-Type": "application/json"},
            method: "PUT",
            mode:"cors",
        }).then(response  => response.json().then(response.ok ? fullfill : reject, reject), reject));
    }

    deleteById(id){
        return new Promise((fullfill, reject) =>fetch(this.url + this.endpoint + id, {
            headers: { "Content-Type": "application/json" },
            method: "DELETE",
            mode: "cors",
        }).then(response => response.json().then(response.ok ? fullfill : reject, reject), reject));
    }

}