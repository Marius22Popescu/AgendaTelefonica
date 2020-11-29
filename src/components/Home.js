import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';  //conecteaza backendul cu frontendul


class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            persoana:null
        }
        this.showPersoane = this.showPersoane.bind(this); 
    }
    //metoda care se executa dupa render
  componentDidMount = () => { 
    //get persoane from db
    console.log()
    axios.get('http://localhost:8080/api/persoana/3').then(    //conecteaza cu backendul
         (response) => {
             this.setState({persoana: response.data});       //ia raspuns din db si seteaza state in variabile
             
         }).catch ( (error) => {
             console.log(error)
            });  
            console.log(this.state.data); 
      
}  
   //metoda care va afisa o persona, o sa fie chemata in render pentru fiecare persoana
showPersoane = () => {
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
//afiseza ui
  render(){
    return(
      <div className='App'>
      <h3>{this.showPersoane()}</h3>
      </div>
    )
  }
 }

 export default Home;