import './App.css';
import {useState} from 'react'
import Map from './components/Map'
import Input from './components/Input/index'
import Loader from "react-loader-spinner";

function App() {
  const [isLoading, setIsLoading] = useState(false);
  const [data,setData] = useState([])

  return (
    <div className="App">
      <Input isLoading={isLoading} data={data} setData={setData} setLoading={setIsLoading} />
      {
        isLoading ? <Loader className={"loader"} type="Circles" color="#166C5C" height={80} width={80} /> : <Map data={data}/>
      }
    </div>
  );
}

export default App;
