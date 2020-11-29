import React,{Component} from 'react';
import {Route, Switch, withRouter} from "react-router-dom"; //ca sa schimbe intre pagini
import axios from 'axios';  //pentru a conecta cu backend 
import './App.css';
import Home from './components/Home';

class App extends Component{
  constructor(props){
    super(props);
    this.state={
      persoana:null,
      persoane:null,
      pId:null
    }
    this.displayPersoane = this.displayPersoane.bind(this); //conecteaza state methods cu methodele
  }
  
  //metoda care o sa fie executata dupa render
  componentDidMount = () => { 
    //ia persoanele din db
    console.log()
    axios.get('http://localhost:8080/api/persoane').then(    //connecteaza cu backendul
         (response) => {
             this.setState({persoana: response.data});       //ia raspunsul din db si seteaza starea in variabile
             
         }).catch ( (error) => {
             console.log(error)
            });  
            console.log(this.state.data); 
      
}  
//metoda care va afisa o persona, o sa fie chemata in render pentru fiecare persoana
displayPersoane = () => {
    return(
        <div>
            {
            Array.from(this.state.data).map( persoana => (                 
                <p3>
                    <div style={{ marginTop: 10 }}>
                   $ {persoana.nume}, {persoana.telefon}, {persoana.email} <br/>
                   </div>
                </p3>
            ))}
        </div>
    );
} 

//aceasta methoda o sa salveze o noua persoana in db
salveazaPersoana = (nume, telefon, email) => {  
  this.setState=({
    nume: nume, 
    telefon: telefon,
    email: email
}); 
    axios.post('http://localhost:8080/api/persoana', //conecteaza cu backendul
    { //pune variabilele in post body
    nume: nume, 
    telefon: telefon,
    email: email
    }) 
   .then(  
      (response) => {
          this.setState({data: response.data});  
      }).catch ((error) => {
          console.log(error.response)
         });
}

//aceasta metoda va sterge o persona din db
stergePersoana = (pId) =>{
  axios.delete('http://localhost:8080/api/persoana/'+pId) //conecteaza cu backendul
  .then(response => {
    console.log("successfully deleted");
}).catch( error => {
  console.log("Nu functioneaza.")
})
}

  render(){
    return(
      <div className='App'>
      <h3>{this.displayPersoane()}</h3>
      </div>
    )
  }
 }

 export default withRouter(App);