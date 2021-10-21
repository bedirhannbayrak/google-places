import './input.css'
import {useState} from 'react'
import axios from 'axios'

const Input = ({isLoading,setLoading,setData,data}) => {
  const [error, setError] = useState("idle");
  const [{latitude,longitude,radius},setInputs] = useState({
    latitude:  "",
    longitude: "",
    radius: ""
  })


  const fetchData = async ()=> {
    setLoading(true);
    setError("")
    try {
      const result = await axios(
          `/api?lat=${latitude}&lng=${longitude}&radius=${radius}`,
      );
      setData(result.data);
    } catch (err){
      const data = err.response ? err.response.data : "Server error";
      setError(data);
      setData([])
    }
    setLoading(false);
  }

  function handleSubmit(e) {
    e.preventDefault()
    setInputs((prev)=>({...prev,
          latitude,
          longitude,
          radius
        })
    )
    fetchData()
  }

  const handleChange = (e) => {
    setInputs((prev) => ({
      ...prev,
    [e.target.name]:e.target.value
    }))
  };

  return (
      <div className="search">
        <div className="card-body">
          <h2 className="title">Search Places</h2>
          <form onSubmit={handleSubmit}>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Latitude"
                     value={latitude}
                     onChange={handleChange}
                     name="latitude"/>
            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Longitude"
                     value={longitude}
                     onChange={handleChange}
                     name="longitude"/>

            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Radius(mt)"
                     value={radius}
                     onChange={handleChange}
                     name="radius"/>
            </div>
            {
              error!=="idle" && error && <div className="error">Invalid values</div>
            }
            {
              !error && data.length===0 && !isLoading && <div className="warn">There is no place found at this area</div>
            }
            <div className="btn-group">
              <button className="btn btn--pill "
                      type="submit">Search
              </button>
            </div>
          </form>
        </div>
      </div>
  );
}

export default Input