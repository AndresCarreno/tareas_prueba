import React from "react";
import {Card, CardBody, CardTitle, CardText, Button, Col, Row} from 'reactstrap';

function Tarea({tarea, handleDeleteTarea, handleEditTarea}){

    console.log("work", tarea);
    const taks = tarea.map(t => (
        <Card className="mb-4" key={t.id}>
            <CardBody >
                <Row>
                    <Col md={4}>

                    <CardTitle md={4}>
                        {t.id}
                    </CardTitle> 
                    </Col>
                    <Col md={4}>
                        <CardText md={4}>
                            {t.descrip}
                        </CardText>
                    </Col>
                    <Col md={2}>
                        <Button
                            color="danger"
                            onClick={() => handleDeleteTarea(t.id)}
                            md={4}
                            >
                            Borrar
                        </Button>
                    </Col>
                    <Col md={2}>
                        <Button
                            color="success"
                            onClick={() => handleEditTarea(t)}
                            md={4}
                            >
                            Editar
                        </Button>
                    </Col>
                </Row>
            </CardBody>
        </Card>
      ))

      return(
          taks
      )
}

export default Tarea;