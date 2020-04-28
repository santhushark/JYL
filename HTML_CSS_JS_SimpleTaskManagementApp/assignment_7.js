function Add_to_table(tsk_name){
    document.getElementsByName("task_name")[0].value = "";
    if(tsk_name.trim()){
        var table1_id = document.getElementById("one");
        var curr_index = table1_id.rows.length;
        var curr_row = table1_id.insertRow(-1);
        
        // var text_box = document.createElement('input');
        // text_box.type = "text";
        // text_box.setAttribute("class", "edit_task_name_text_box");

        var name_update_button = document.createElement('input');
        name_update_button.type = "button";
        name_update_button.setAttribute("class", "custom_button");
        name_update_button.value = "Edit";
        name_update_button.onclick = function(){edit_task_name(this)};

        var completed_task_button = document.createElement('input');
        completed_task_button.type = "button";
        completed_task_button.setAttribute("class", "custom_button");
        completed_task_button.value = "completed";
        completed_task_button.onclick = function(){update_task_list_table(this)};

        var curr_cell = curr_row.insertCell(-1);
        curr_cell.innerHTML = tsk_name;

        // curr_cell = curr_row.insertCell(-1);
        // curr_cell.appendChild(text_box);

        curr_cell = curr_row.insertCell(-1);
        curr_cell.appendChild(name_update_button);

        curr_cell = curr_row.insertCell(-1);
        curr_cell.appendChild(completed_task_button);
    }
}

function edit_task_name(cell){
    var this_row_index = cell.parentNode.parentNode.rowIndex;
  //  var new_name = document.getElementById("one").rows[this_row_index].cells[1].children[0].value;
    
//   if(new_name.trim()){
        // document.getElementById("one").rows[this_row_index].cells[0].innerHTML = new_name;
        document.getElementById("one").rows[this_row_index].cells[0].innerHTML = "";
        document.getElementById("one").rows[this_row_index].cells[0].setAttribute('contentEditable', true);
       // document.getElementById("one").rows[this_row_index].cells[1].children[0].value = "";
   // }
}

function update_task_list_table(cell){
    var this_row_index = cell.parentNode.parentNode.rowIndex;
    var task_name = document.getElementById("one").rows[this_row_index].cells[0].innerHTML;
    update_completed_task_list(task_name);
    document.getElementById("one").deleteRow(this_row_index);
}

function update_completed_task_list(task_name){
    var table1_id = document.getElementById("two");
    var curr_row = table1_id.insertRow(-1);

    var delete_button = document.createElement('input');
    delete_button.type = "button";
    delete_button.setAttribute("class", "custom_delete_button");
    delete_button.value = "delete";
    delete_button.onclick = function(){update_completed_task_list_table(this)};
    

    var curr_cell = curr_row.insertCell(-1);
    curr_cell.innerHTML = task_name;

    curr_cell = curr_row.insertCell(-1);
    curr_cell.appendChild(delete_button);
}

function update_completed_task_list_table(cell){
    var this_row_index = cell.parentNode.parentNode.rowIndex;
    document.getElementById("two").deleteRow(this_row_index);
}