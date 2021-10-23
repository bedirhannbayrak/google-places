import axios from 'axios'

const fetchData = async ({setLoading,setError,latitude,longitude,radius,setData})=> {
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

export default fetchData