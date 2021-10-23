import {render,screen} from '@testing-library/react'
import '@testing-library/jest-dom/extend-expect';
import '@testing-library/user-event'
import userEvent from '@testing-library/user-event'

import Input from '../components/Input'

it("Input component renders without crashing", () => {
  render(<Input isLoading={false} data={[]} setLoading={jest.fn()} setData={jest.fn
  }/>)
  const input  =screen.getByTestId("latitude")
  expect(input).toBeInTheDocument()

});

it("when type latitude input, input value should change", () => {
  render(<Input />)
  const input  =screen.getByTestId("latitude")
  userEvent.type(input,"test")
  expect(input).toHaveValue("test")
});

it("when type longitude input, input value should change", () => {
  render(<Input />)
  const input  =screen.getByTestId("longitude")
  userEvent.type(input,"test")
  expect(input).toHaveValue("test")
});

it("when type radius input, input value should change", () => {
  render(<Input />)
  const input  =screen.getByTestId("radius")
  userEvent.type(input,"test")
  expect(input).toHaveValue("test")
});
