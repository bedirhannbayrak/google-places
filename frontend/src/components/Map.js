import React from 'react';
import GoogleMapReact from 'google-map-react';

const AnyReactComponent = () => <div className={'marker'}>
  <img
      src="https://cdn.pixabay.com/photo/2014/04/03/10/03/google-309739_960_720.png"
      alt="marker"/>
</div>;

export default function SimpleMap({data}) {

  return (
      <div className={'map'}>
        <GoogleMapReact
            bootstrapURLKeys={{key: process.env.REACT_APP_MAP_API}}
            defaultCenter={{
              lat: data.length > 0 ? data[0].location.lat : 40,
              lng: data.length > 0 ? data[0].location.lng : 30
            }}
            defaultZoom={9}
            yesIWantToUseGoogleMapApiInternals
        >
          {
            data?.map((item, idx) => (
                <AnyReactComponent
                    lat={item.location.lat}
                    lng={item.location.lng}
                    key={idx}
                />
            ))
          }
        </GoogleMapReact>
      </div>
  );
}