import { createBrowserRouter } from "react-router-dom"
import { AuthContextProvider } from "../../contexts/AuthContext/AuthContextProvider";
import { Home } from "../../pages/Home/Home";
import { Courses } from "../../pages/Courses/Courses";
import { Layout } from "../layouts/MainLayout/Layout"
import { NotFound } from "../../pages/NotFound/NotFound"
import { Course } from "../Course/Course"
import { Contacts } from "../../pages/Contacts/Contacts";
import { ProtectedRoute } from "../ProtectedRoute";


export const router = createBrowserRouter([
    {
      element: <AuthContextProvider><Layout/></AuthContextProvider>,
      children:[
        {
          path: "/",
          children: [
            {
              path: "",
              element: <Home />
            },
            {
              path: "/contacts",
              element: <ProtectedRoute><Contacts /></ProtectedRoute>
            },
            {
              path: "/courses/",
              children:[
                {
                  path:"",
                  element: <ProtectedRoute><Courses /></ProtectedRoute>
                },
                {
                  path:"course/:id",
                  element: <Course/>
                }
              ]
            }
          ]
        }
      ]
    },
    {
      path: "*",
      element: <NotFound />
    }
  ]);