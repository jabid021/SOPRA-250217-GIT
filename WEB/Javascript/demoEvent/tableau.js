
  inputPrenom.onkeyup=verifInput;
  btnAjouter.onclick=ajoutPrenom;


  function verifInput(event)
  {
    if(event.key=="Enter")
    {
      ajoutPrenom();
    }

    else
    {
      let content = inputPrenom.value;
      if(content=="")
      {
        btnAjouter.disabled=true;
        loginStatut.style.backgroundColor="red";
      }
      else
      {
        btnAjouter.disabled=false;
        loginStatut.style.backgroundColor="green";
      }
    }
  }


  function ajoutPrenom()
  {
      let content = inputPrenom.value;
      tableau.innerHTML += `<tr><td>${content}</td></tr>`;
      inputPrenom.value="";
      btnAjouter.disabled=true;
      loginStatut.style.backgroundColor="red";
  }
