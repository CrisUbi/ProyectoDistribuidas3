(function (window, document, JSON)
{
    'use strict';

    var url = 'ws://' + window.location.host + '/prj_chat_websocket/chat',
            ws = new WebSocket(url),
            mensajes = document.getElementById('conversacion'),
            mensajes1 = document.getElementById('conversacion1'),
            boton = document.getElementById('btn_enviar'),
            nombre = document.getElementById('usuario'),
            mensaje = document.getElementById('mensaje'),
            tabla = document.getElementById('tabla');

    ws.onopen = onOpen;
    ws.onclose = onClose;
    ws.onmessage = onMessage;

    boton.addEventListener('click', enviar);

    function onOpen()
    {
        console.log('Conectado');

    }
    function onClose()
    {
        console.log('Desconectado');
    }
    function enviar()
    {
        var msg = {
            nombre: nombre.value,
            mensaje: mensaje.value
        };
        ws.send(JSON.stringify(msg));

    }
    function onMessage(evt)
    {

        var momentoActual = new Date(),
                hora = momentoActual.getHours(),
                minuto = momentoActual.getMinutes(),
                segundo = momentoActual.getSeconds(),
                horaImprimible = hora + ":" + minuto + ":" + segundo,
                dia = momentoActual.getDate(),
                mes = momentoActual.getMonth() + 1,
                anio = momentoActual.getFullYear(),
                fechaImprimible = dia + "/" + mes + "/" + anio;
        var obj = JSON.parse(evt.data),
                msg = 'Fecha:' + obj.fecha + '    Hora:' + obj.hora + '  </br>    ' + obj.nombre + ' dice: ' + obj.mensaje;
        mensajes.innerHTML += '</br>' + msg;
       
        

    }
})(window, document, JSON);


