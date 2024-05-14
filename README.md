# Segundo Projeto Android Java para a Faculdade

## Aplicativo desenvolvido para adicionar ou excluir valores referente ao ano de um MEI

## Com este projeto aprendi:

- Views: NumberPicker, RadioGroup, RadioButton
- ViewGroup: ConstraintLayout
- SharedPreferences: é um mecanismo de armazenamento chave-valor para pequenas quantidades de dados. Os dados são armazenados em um arquivo XML no diretório de dados do aplicativo. O tamanho máximo é de 1MB. As alterações no arquivo XML são gravadas de forma assíncrona.
- Para definir valor máximo e mínimo no NumberPicker: setMinValue(), setMaxValue()
- setOnValueChangedListener(): método que define um ouvinte para quando um valor de uma variável mudar.
- setOnClickListener(): método que define um ouvinte para quando uma view for clicada.
- Toast: mensagem curta que fornece um feedback ao usuário sobre uma operação ou evento. Possui dois métodos principais: makeText() e show().
- Float.parseFloat(): é equivalente ao código new Float().parseFloat(). No entanto, o código Float.parseFloat() é mais conciso e legível.
- getCheckedRadioButtonId(): é usado para obter o ID do botão radio selecionado em um grupo de botões de radio. Retorna -1 se nenhum botão estiver selecionado.
- Intent: são usados para iniciar atividades, serviços e enviar mensagens entre componentes do aplicativo. Neste projeto foi utilizado o método startActivity(intent) para iniciar uma nova tela ao clicar no botão.
- onResume(): método do ciclo de vida de uma atividade e é chamado quando a atividade está retomando o foco. É chamado após o método onStart() e antes do método onPostResume(). Em resumo, ele é usado para realizar tarefas que precisam ser feitas quando a atividade está visível para o usuário. Não é chamado quando a atividade é criada pela primeira vez.

![Screenshot](firstProjectICMSimg.png)
