# Google Places Api

[Live](http://54.93.128.152:8070/)
## Installation with Docker

You must have these before installing the app : 
 - [Maps Javascript API](https://console.cloud.google.com/google/maps-apis/apis/maps-backend.googleapis.com/metrics?project=ace-axon-329613)
 - [Google Places API](https://console.cloud.google.com/google/maps-apis/apis/places-backend.googleapis.com/metrics?project=ace-axon-329613)
 
 
```sh
git clone https://github.com/bedirhannbayrak/google-places
cd google-places
```
- Open docker-compose.yml file
- Replace your api keys to relevant fields 

- Go ./frontend directory
-  Create .env file nd insert this line with your api key
- `REACT_APP_MAP_API=<Your Maps Javascript Api>`
- Go back previous folder(./google places)
- run this command
- `docker-compose up -d`
-  After the build stages, the application must be running on port 8070
