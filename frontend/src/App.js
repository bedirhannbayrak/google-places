import './App.css';
import {useEffect, useState} from 'react'
import Map from './components/Map'
import Input from './components/Input/index'
import axios from 'axios'

function App() {
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
  const [data,setData] = useState([])
  const [inputs,setInputs] = useState({
    latitude:  40,
    longitude: 30 ,
    radius:'5000'
  })

  useEffect( () => {
    const fetchData = async ()=> {
      setIsLoading(true);
      setError(null)
      try {
        const result = await axios(
            `http://localhost:8070/api?lat=${inputs.latitude}&lng=${inputs.longitude}&radius=${inputs.radius}`,
        );
        setData(result.data);
      } catch (err){
        const data = err.response ? err.response.data : "Server error";
        setError(data);
      }
      setIsLoading(false);
    }
    fetchData()
  }, [inputs.latitude,inputs.longitude,inputs.radius]);

  return (
    <div className="App">
      <Input resultLength={data.length} error={error} setInputs={setInputs}/>
      {
        isLoading ? "loading" : <Map data={data}/>
      }
    </div>
  );
}

export default App;
