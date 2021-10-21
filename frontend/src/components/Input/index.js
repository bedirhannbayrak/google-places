import './input.css'
import {useReducer} from 'react'

const Input = ({setInputs,error,resultLength}) => {

  const initialValue = {
    latitude: '',
    longitude: '',
    radius: ''
  };

  const reducer = (state, action) => {
    switch (action.type) {
      case 'update':
        return {
          ...state,
          [action.payload.key]: action.payload.value
        };
      default:
        throw new Error(`Unknown action type: ${action.type}`);
    }
  };

  const [state, dispatch] = useReducer(reducer, initialValue);

  function handleSubmit(e) {
    e.preventDefault()
    setInputs(() => ({
          latitude: state.latitude,
          longitude: state.longitude,
          radius: state.radius,
        }
    ))
  }

  const handleChange = (event) => {
    dispatch({
      type: 'update',
      payload: {key: event.target.name, value: event.target.value}
    });
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
                     value={state.latitude}
                     onChange={handleChange}
                     name="latitude"/>
            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Longitude"
                     value={state.longitude}
                     onChange={handleChange}
                     name="longitude"/>

            </div>
            <div className="input-group">
              <input className="input"
                     type="text"
                     placeholder="Radius(mt)"
                     value={state.radius}
                     onChange={handleChange}
                     name="radius"/>
            </div>
            {
              error && <div className="error">Invalid values</div>
            }
            {
              !error && resultLength===0 && <div className="warn">There is no place found at this area</div>
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