import './input.css'
import {useReducer, useState} from 'react'

import fetchData from "../../utils/fetch"
import reducer,{initialValue} from "../../utils/reducer"

const Input = ({isLoading,setLoading,setData,data}) => {
  const [error, setError] = useState("idle");
  const [{latitude,longitude,radius}, dispatch] = useReducer(reducer, initialValue);

  const handleChange = (e) => {
    dispatch({
      type: 'update',
      payload: { key: e.target.name, value: e.target.value },
    });
  };



  function handleSubmit(e) {
    e.preventDefault()
    fetchData({setLoading,setData,setError,latitude,longitude,radius,})
  }

  return (
      <div className="search">
        <div className="card-body">
          <h2 className="title">Search Places</h2>
          <form onSubmit={handleSubmit}>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Latitude"
                     data-testid="latitude"
                     value={latitude}
                     onChange={handleChange}
                     name="latitude"/>
            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Longitude"
                     data-testid="longitude"
                     value={longitude}
                     onChange={handleChange}
                     name="longitude"/>

            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Radius(mt)"
                     data-testid="latitude"
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
                      data-testid="search"
                      type="submit">Search
              </button>
            </div>
          </form>
        </div>
      </div>
  );
}

export default Input